package com.sreviewonly.board.service;

import com.sreviewonly.board.dto.ReviewDTO;
import com.sreviewonly.board.dto.UserDTO;
import com.sreviewonly.board.entites.Product;
import com.sreviewonly.board.entites.Review;
import com.sreviewonly.board.entites.User;
import com.sreviewonly.board.entites.enums.PREFERSEX;
import com.sreviewonly.board.repositories.ProductRepository;
import com.sreviewonly.board.repositories.ReviewRepository;
import com.sreviewonly.board.repositories.UserRepository;
import com.sreviewonly.board.util.FileNameRandomization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository;
    @Override
    public void signUpRegister(String email, String password, String nickname, MultipartFile profile_pic, MultipartFile background_pic, PREFERSEX prefersex) {
        String profilePictureNewName = FileNameRandomization.uploadFileWithUUID(profile_pic);
        String backgroundPictureNewName = FileNameRandomization.uploadFileWithUUID(background_pic);
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(email);
        userDTO.setPassword(password);
        userDTO.setNickname(nickname);
        userDTO.setProfile_pic(profilePictureNewName);
        userDTO.setBackground_pic(backgroundPictureNewName);
        userDTO.setOtherElement();

        User user = new User.UserBuilder(userDTO).build();

        userRepository.save(user);
    }

    @Override
    public void insertReview(MultipartFile profilePic, String title, String content, double star, UserDTO userDTO) {
        String profilePictureNewName = FileNameRandomization.uploadFileWithUUID(profilePic);
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setUserDTO(userDTO);
        reviewDTO.setPrefersex(userDTO.getPrefersex());
        reviewDTO.setMainPic(profilePictureNewName);
        reviewDTO.setTitle(title);
        reviewDTO.setStar(star);
        reviewDTO.setContent(content);
        reviewDTO.setOtherElements();
        reviewDTO.setPrefersex(userDTO.getPrefersex());

        Review review = new Review.ReviewBuilder(reviewDTO).build();
        User user = userRepository.findById(userDTO.getId()).get();
        review.setUser(user);
        Product product = productRepository.findById(3L).get();
        review.setProduct(product);

        reviewRepository.save(review);
    }
}
