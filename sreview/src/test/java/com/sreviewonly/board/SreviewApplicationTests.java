package com.sreviewonly.board;

import com.sreviewonly.board.entites.*;
import com.sreviewonly.board.entites.enums.PREFERSEX;
import com.sreviewonly.board.entites.enums.ROLE;
import com.sreviewonly.board.entites.enums.VIPRANK;
import com.sreviewonly.board.repositories.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
	public ProductToReviewRepository productToReviewRepository;

	@Autowired
	public ReviewToHashtagRepository reviewToHashtagRepository;

	@Autowired
	public UserToReviewLikesRepository userToReviewLikesRepository;

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
			user.setRole(ROLE.MEMBER);
			user.setProfile_pic("default.jpg");
			user.setBackground_pic("default.jpg");
			userRepository.save(user);
		}


	}

	@Test
	void reviewMakeTest(){

		for(int i=1;i<=10;i++){
			Review review = new Review();
			review.setTitle("my title" + i);
			review.setContent("my textarea" + i);
			review.set_deleted(false);
			review.setHits(0L);
			review.setLikes(0L);
			review.set_hided(false);

			reviewRepository.save(review);
		}
	}

	@Test
	void commentMakeTest(){
		Review review = reviewRepository.findById(10L).get();
		for(int i=1;i<=10;i++){
			Comment comment = new Comment();
			comment.setContent("content"+i);
			comment.setReview(review);
			commentRepository.save(comment);
		}
	}

	@Test
	void ProductMakeTest(){
		for(int i=1;i<=10;i++){
			Product product = new Product();
			product.setProductName("mmt_aimi");
			product.setProductPic("default.jpg");
			product.setProductShop("my_shop");
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


	@Test
	void N_M_Test(){
		Review review = reviewRepository.findById(1L).get();
		for(ProductToReview ptr:review.getProductToReviewList()){
			System.out.println(ptr.getProduct().getId());
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

	//10명이 좋아요를 누르고 게시글의 좋아요 수를 조회해보기. 조회수도 올리기. / JPQL을 이용한 구현.
	@Test
	void UserToReviewLikesRepositoryTest(){

		List<UserToReviewLikes> userToReviewLikesList = new ArrayList<>();
		for(long i=1;i<=10;i++){
			User user = userRepository.findById(i).get();
			Review review = reviewRepository.findById(1L).get();
			UserToReviewLikes userToReviewLikes = new UserToReviewLikes();
			userToReviewLikes.setUser(user);
			userToReviewLikes.setReview(review);
			userToReviewLikesList.add(userToReviewLikes);
		}
		userToReviewLikesRepository.saveAll(userToReviewLikesList);



	}

	//좋아요 삭제 & 좋아요 수 확인
	@Test
	void remove_like_and_count(){
		Review review = reviewRepository.findById(1L).get();
		User user = userRepository.findById(2L).get();
		userToReviewLikesRepository.deleteByReviewAndUser(review,user);

		System.out.println(review.getUserToReviewLikesList().size());

	}


}


