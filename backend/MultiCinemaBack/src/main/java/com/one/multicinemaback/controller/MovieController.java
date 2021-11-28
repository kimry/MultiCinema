package com.one.multicinemaback.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.one.multicinemaback.dto.ActorDto;
import com.one.multicinemaback.dto.MovieDto;
import com.one.multicinemaback.dto.ReviewDto;
import com.one.multicinemaback.service.ActorService;
import com.one.multicinemaback.service.MovieService;
import com.one.multicinemaback.service.ReviewService;




@RestController
public class MovieController {

	
	  @Autowired 
	  private MovieService service;
	  
	  @Autowired
	  private ActorService aservice;
	  
	  @Autowired
	  private ReviewService mservice;
	  
      @RequestMapping(value = "/movielist", method = RequestMethod.GET) 
	  public List<MovieDto> list(){
		  System.out.println("MovieController list()");
		  
		  List<MovieDto> list = service.getmovielist();
		  
	  return list;
	  
	  }
      
      @RequestMapping(value = "/moviedetail", method = RequestMethod.GET)
  	  public MovieDto moviedetail(int seq) {
  		  System.out.println("MovieController Moviedetail()");
  		  
  		  System.out.println(seq);
  		  
  		  System.out.println(service.getMovie(seq));
  		
  		  return service.getMovie(seq);
  	  }
      
      @RequestMapping(value = "/getActor", method = RequestMethod.GET)
      public List<ActorDto> getActor(int seq) {
    	  
    	  System.out.println("MovieController getActor()");
    	  
    	  return aservice.getActor(seq);    	// seq actor  
      }
      
      @RequestMapping(value = "/actordetail", method = RequestMethod.GET)
    	public ActorDto actordetail(int aid) {
    		System.out.println("MovieController actordetail()");
    		
    		return aservice.getActorInfo(aid);
    		
      }
      
      @RequestMapping(value = "/actorMovie", method = RequestMethod.GET)
      	public ActorDto getActorMovie(int aid) {
    	  System.out.println("MovieController getActorMovie()");
    	  
    	  return aservice.getActorMovie(aid);
      }
  	
  	  @RequestMapping(value = "/reviewlist", method = RequestMethod.GET) 
  	  public List<ReviewDto> reviewList(int seq) throws Exception{
  		  System.out.println("ReviewController reviewList()");

  		  System.err.println();
  		  
  		  List<ReviewDto> list = mservice.reviewList(seq);
  		  
  	  return list;
  	  
  	  }
  	
   	  @RequestMapping(value = "/reviewinsert", method = RequestMethod.POST) 
  	  public String reviewInsert(ReviewDto dto) throws Exception{
  		  System.out.println("ReviewController reviewInsert()");
  		  System.out.println(dto.toString());
  		  
  		  mservice.reviewInsert(dto);
  		  service.updateScore(dto.getSeq());
  	  return "success";
  	  
  	  }
  	 
   	  @RequestMapping(value = "/reviewupdate", method = RequestMethod.GET)
   	  public int reviewUpdate(int rnum, String content) throws Exception {
   		  System.out.println("ReviewController reviewUpdate()");

  		  System.err.println();
  		  
  		  ReviewDto review = new ReviewDto();
  		  review.setRnum(rnum);
  		  review.setContent(content);
  		 
  		  return mservice.reviewUpdate(review);
  		 
  	 }
  	 
  	 @RequestMapping(value = "/reviewdelete", method = RequestMethod.GET)
  	 public int reviewDelete(int rnum) throws Exception {
  		  System.out.println("ReviewController reviewDelete()");

  		  System.err.println();
  		  
  		 return mservice.reviewDelete(rnum);
  	 }
}
