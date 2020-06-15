package project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.exception.RecordNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TopicController {
	
	@Autowired
	TopicService service;
	
	@RequestMapping("/topics")
    public ResponseEntity<List<Topic>> getAllTopics() {
        List<Topic> list = service.getAllTopics();
 
        return new ResponseEntity<List<Topic>>(list, new HttpHeaders(), HttpStatus.OK);
    }
	
	@RequestMapping("/topics/{id}")
	    public ResponseEntity<Topic> getEmployeeById(@PathVariable("id") String id) 
	                                                    throws RecordNotFoundException {
	        Topic t1 = service.getTopic(id);
	 
	        return new ResponseEntity<Topic>(t1, new HttpHeaders(), HttpStatus.OK);
	    }
	 
	@RequestMapping(method=RequestMethod.POST , value="/topics" )
	    public ResponseEntity<Topic> addTopic(Topic topic)
	                                                    throws RecordNotFoundException {
	        Topic added = service.addTopic(topic);
	        return new ResponseEntity<Topic>(added, new HttpHeaders(), HttpStatus.OK);
	    }
	 
	 @PostMapping("/topics/put")
	    public ResponseEntity<Topic> updateTopic(Topic topic) throws RecordNotFoundException {
	        Topic updated = service.updateTopic(topic);
	        return new ResponseEntity<Topic>(updated, new HttpHeaders(), HttpStatus.OK);
	    }
	 
	 @RequestMapping(method=RequestMethod.DELETE , value="/topics/{id}")
	    public HttpStatus deleteTopic(@PathVariable("id") String id) throws RecordNotFoundException {
	        service.deleteTopic(id);
	        return HttpStatus.FORBIDDEN;
	    }
	 
}
