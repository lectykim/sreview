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
}
