package com.sreviewonly.board;

import com.sreviewonly.board.entites.*;
import com.sreviewonly.board.entites.enums.PREFERSEX;
import com.sreviewonly.board.entites.enums.ROLE;
import com.sreviewonly.board.entites.enums.VIPRANK;
import com.sreviewonly.board.repositories.*;
import com.sreviewonly.board.util.Pagination;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
	public ReviewToHashtagRepository reviewToHashtagRepository;

	@Autowired
	public HeartRepository heartRepository;

	@Autowired
	public Pagination pagination;

	//Test All Change Because Entity -> DTO Structure change

	@Test
	public void userInput(){
		for(long i=1;i<10;i++){
			User user = new User("email"+i+"@email.com","nickname"+i,"password"+i,VIPRANK.BRONZE,ROLE.SELLER,0L,"default.jpg","default.jpg",false,PREFERSEX.WMT);
			userRepository.save(user);
		}

	}

	@Test
	public void ReviewInputAndUser(){
		for(long i=1;i<10;i++){
			User user = userRepository.findById(i).get();
			Review review = new Review(0L,"content"+i,5.0,"title"+i,false,false,0L,PREFERSEX.WMT,"default.jpg");
			review.setUser(user);
			reviewRepository.save(review);
		}
	}

	@Test
	public void productInput(){
		for(long i=1;i<10;i++){
			Product product = new Product("default.jpg","product"+i,"shop"+i,1000L,"shopLink.com",PREFERSEX.WMT);
			productRepository.save(product);
		}
	}

	@Test
	public void commentInput(){
		for(long i=1;i<10;i++){
			User user = userRepository.findById(i).get();
			Review review = reviewRepository.findById(i).get();
			Comment comment = new Comment("reply : "+i,user);
			commentRepository.save(comment);
			review.setComment(comment);
			reviewRepository.save(review);
		}
	}

	@Test
	public void reviewSetProduct(){
		for(long i=1;i<10;i++){
			Review review = reviewRepository.findById(i).get();
			Product product = productRepository.findById(i).get();
			review.setProduct(product);
			reviewRepository.save(review);
		}
	}

	@Test
	public void review_pageTest(){
		for(long i=10;i<1010;i++){
			Review review = new Review(0L,"content"+i,5.0,"title"+i,false,false,0L,PREFERSEX.WMT,"default.jpg");
			reviewRepository.save(review);
		}
	}

	@Test
	public void review_pageTestAfterDelete(){
		for(long i=1009;i>=10;i--){
			reviewRepository.deleteById(i);
		}
	}

	@Test
	public void paginationNullTest(){
		pagination.findPageInformation(15,PREFERSEX.WMT);
	}


}


