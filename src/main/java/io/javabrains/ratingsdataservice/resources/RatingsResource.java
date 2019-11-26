package io.javabrains.ratingsdataservice.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.ratingsdataservice.model.Rating;
import io.javabrains.ratingsdataservice.model.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

	
	private Logger logger=LoggerFactory.getLogger(RatingsResource.class);
	
    @RequestMapping(value="/movies/{movieId}" )

    public Rating getMovieRating(@PathVariable("movieId") String movieId) {
    	logger.info("in getMovieRating");
        return new Rating(movieId, 4);
    }

    @RequestMapping("/user/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") String userId) {
    	logger.info("in getUserRatings");
        UserRating userRating = new UserRating();
        userRating.initData(userId);
        return userRating;

    }

}
