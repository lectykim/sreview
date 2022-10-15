package com.sreviewonly.board;

import com.sreviewonly.board.entites.*;
import com.sreviewonly.board.entites.enums.PREFERSEX;
import com.sreviewonly.board.entites.enums.ROLE;
import com.sreviewonly.board.entites.enums.VIPRANK;
import com.sreviewonly.board.repositories.*;
import com.sreviewonly.board.service.ArrangeService;
import com.sreviewonly.board.util.Pagination;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
class SreviewApplicationTests {

	@Autowired
	public UserRepository userRepository;
	@Autowired
	public ReviewRepository reviewRepository;

	@Autowired
	public ProductRepository productRepository;

	@Autowired
	public CommentRepository commentRepository;

	@Autowired
	public HashtagRepository hashtagRepository;


	@Autowired
	public ArrangeService arrangeService;

	@Autowired
	public ReviewToHashtagRepository reviewToHashtagRepository;

	@Autowired
	public HeartRepository heartRepository;

	@Autowired
	public Pagination pagination;



	@Test
	void contextLoads() {

	}

	//user make test
	@Test
	void userMakeTest(){
		for(int i=1;i<=10;i++){
			User user = new User();
			user.setEmail("abc"+i+"@email.com");
			user.setNickname("nick"+i+"name");
			user.setPassword("password");
			user.setPoint(0L);
			user.setViprank(VIPRANK.BRONZE);
			user.set_banned(false);
			user.setPrefersex(PREFERSEX.MMT);
			user.setRole(ROLE.SELLER);
			user.setProfile_pic("default.jpg");
			user.setBackground_pic("default.jpg");
			userRepository.save(user);
		}


	}

	@Test
	void reviewMakeTest(){

		for(int i=1;i<=1000;i++){
			Review review = new Review();
			review.setTitle("my title" + i);
			review.setContent("my textarea" + i);
			review.set_deleted(false);
			review.setHits(0L);
			review.setLikes(0L);
			review.setPrefersex(PREFERSEX.WMT);
			review.set_hided(false);
			review.setMainPic("default.jpg");
			reviewRepository.save(review);
		}
	}

	@Test
	void commentMakeTest(){

		for(int i=1;i<=10;i++){
			Review review = reviewRepository.findById((long)i).get();
			User user = userRepository.findById((long)i).get();
			Comment comment = new Comment();
			comment.setContent("content"+i);
			//comment.setReview(review);
			comment.setUser(user);

			commentRepository.save(comment);
		}
	}

	@Test
	void mappingOneToOne(){
		Review review = reviewRepository.findById(1L).get();
		Comment comment = commentRepository.findById(2L).get();
		review.setComment(comment);
		System.out.println(review.getComment().getContent());
	}

	@Test
	void ProductMakeTest(){
		for(int i=1;i<=10;i++){
			Product product = new Product();
			product.setProductName("mmt_aimi "+ i);
			product.setProductPic("default.jpg");
			product.setProductShop("my_shop "+ i);
			product.setProductPrice(300000L);
			product.setProductPreferSex(PREFERSEX.MMT);
			productRepository.save(product);
		}
	}

	@Test
	void mappingUserToReview(){
		User user = userRepository.findById(1L).get();
		for(Long i=1L;i<=10L;i++){
			Review review = reviewRepository.findById(i).get();
			System.out.println(review.getId() + " |||  " + review.getContent());
			review.setUser(user);
			reviewRepository.save(review);
		}
	}

	@Test
	void mappingProductToReview(){
		List<Review> list = new ArrayList<>();
		for(long i=1;i<=10;i++){
			Review review = reviewRepository.findById(i).get();
			Product product = productRepository.findById(i%3+1).get();
			review.setProduct(product);
			list.add(review);
		}
		reviewRepository.saveAll(list);
	}

	@Test
	void mappingCommentToReview(){
		for(long i=2;i<=11;i++){
			Review review = reviewRepository.findById(i).get();
			Comment comment = commentRepository.findById(i).get();
			review.setComment(comment);
			reviewRepository.save(review);
		}
	}


	@Test
	void findReviewByProduct(){
		Product product = productRepository.findById(1L).get();
		List<Review> list = product.getReviewList();
		for(Review review:list){
			System.out.println(review.getContent());
		}

	}


	@Test
	void reverseUserToReviewTest(){
		User user = userRepository.findById(1L).get();
		for(Review reviews:user.getReviews()){
			System.out.println(reviews.getId());
			System.out.println("|||");
			System.out.println(reviews.getContent());
			System.out.println("|||");
		}
	}



	//FetchType.LAZY만 설정하고 똑같이 outer join을 사용한 경우.
	@Test
	void N_1_Test(){
		List<User> userList = userRepository.findAll();
		List<String> reviewerNames = userList.stream().flatMap(it->it.getReviews().stream().map(review -> review.getContent())).collect(Collectors.toList());
		System.out.println(reviewerNames);
	}

	//JPQL로 직접 Fetch Join을 설정해준 경우
	@Test
	void fetch_join_test(){
		List<User> userList = userRepository.findAllWithReviewUsingFetchJoin();
		List<String> reviewerNames = userList.stream().flatMap(it->it.getReviews().stream().map(review -> review.getContent())).collect(Collectors.toList());
		for(String str:reviewerNames){
			System.out.println(str);
		}
	}



	//N:M 매핑의 중간 테이블을 넣어서 잘 동작하는지 확인하는 과정.
	@Test
	void review_to_hashtag_insert(){
		List<Hashtag> hashtagList = new ArrayList<>();
		for(int i=1;i<=10;i++){
			Hashtag hashtag = new Hashtag();
			hashtag.setTagCnt(0L);
			hashtag.setTagId("tag" + i);
			hashtagList.add(hashtag);
		}
		hashtagRepository.saveAll(hashtagList);

		List<ReviewToHashtag> reviewToHashtagList = new ArrayList<>();

		for(long i=1;i<=3;i++){
			Review review = reviewRepository.findById(i).get();
			for(long j=1;j<=3;j++){
				Hashtag hashtag = hashtagRepository.findById(j).get();
				ReviewToHashtag reviewToHashtag = new ReviewToHashtag();
				reviewToHashtag.setReview(review);
				reviewToHashtag.setHashtag(hashtag);
				reviewToHashtagList.add(reviewToHashtag);
			}
		}


		reviewToHashtagRepository.saveAll(reviewToHashtagList);


	}
	@Test
	void review_to_hashtag_select(){

		Review review = reviewRepository.findById(1L).get();
		for(ReviewToHashtag rth : review.getReviewToHashtagList()){

			System.out.println(rth.getHashtag().getTagId());
		}
	}

	//좋아요 추가 구현
	@Test
	void add_hearts(){
		for(long i=1;i<=3;i++){
			User user = userRepository.findById(i).get();
			Heart heart = new Heart();
			heart.setUser(user);
			heart.setReviewId(1L);
			heartRepository.save(heart);
		}

		List<Heart> heartList = heartRepository.findByReviewId(1L);
		System.out.println(heartList.size());
	}



	@Test
	void prefersex_config(){
		List<Review> reviews = new ArrayList<>();
		for(long i=1;i<=10;i++){
			Review review = reviewRepository.findById(i).get();
			review.setPrefersex(PREFERSEX.MMT);
			reviews.add(review);
		}
		reviewRepository.saveAll(reviews);
	}



	@Test
	void updateReview(){
		List<Review> reviews = new ArrayList<>();
		for(long i=1;i<=10;i++){
			User user = userRepository.findById(i).get();
			Review review = reviewRepository.findById(i).get();
			review.setUser(user);
			reviews.add(review);
		}
		reviewRepository.saveAll(reviews);
	}

	@Test
	void paginate_test(){
		PREFERSEX prefersex = PREFERSEX.MMT;
		Map<String,Integer> map = pagination.findPageInformation(15,prefersex);
		Iterator<String> iterator = map.keySet().iterator();
		while(iterator.hasNext()){
			String s = iterator.next();
			System.out.println(s + " : " + map.get(s));
		}

		List<Review> list = arrangeService.findReviewByPreferSexLimitPaging(prefersex,map,1);
		for(Review review:list){
			System.out.println("list :" + review.getId());
		}

	}


}


