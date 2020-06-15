package project;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.exception.RecordNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	TopicDAO topicDAO;
	
	public List<Topic> getAllTopics()
	{
		List<Topic> t1 = topicDAO.findAll();
		if(t1.size()>0)
		{
			return t1;
		}
		else {
			return new ArrayList<Topic>();
		}	
	}
	
	public Topic getTopic(String id) {
		Optional<Topic> t1 = topicDAO.findById(id);
		if(t1.isPresent()) {
			return t1.get();
		}else {
			throw new RecordNotFoundException("No Topic exist for given id");
		}
	}
	
	public Topic addTopic(Topic topic) throws RecordNotFoundException{
        Optional<Topic> t1 = topicDAO.findById(topic.getId());
         
        if(t1.isPresent()) 
        {
            Topic newtopic = t1.get();
            newtopic.setId(topic.getId());
            newtopic.setName(topic.getName());
            newtopic.setDescription(topic.getDescription());
 
            newtopic = topicDAO.save(newtopic);
             
            return newtopic;
        } else {
           topic = topicDAO.save(topic);
            return topic;
        }
    } 
	
	public Topic updateTopic(Topic topic) throws RecordNotFoundException{
        Optional<Topic> t1 = topicDAO.findById(topic.getId());
         
        if(t1.isPresent()) 
        {
            Topic newtopic = t1.get();
            newtopic.setId(topic.getId());
            newtopic.setName(topic.getName());
            newtopic.setDescription(topic.getDescription());
 
            newtopic = topicDAO.save(newtopic);
             
            return newtopic;
        } else {
           topic = topicDAO.save(topic);
            return topic;
        }
    }
	
	public void deleteTopic(String id ) throws RecordNotFoundException{
		Optional<Topic> t1 = topicDAO.findById(id);

        if(t1.isPresent()) 
        {
            topicDAO.deleteById(id);
        } else {
            throw new RecordNotFoundException("No topic record exist for given id");
        }
	}

}
