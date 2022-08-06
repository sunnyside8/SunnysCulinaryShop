package com.example.sunnysculinaryshop.service;

import com.example.sunnysculinaryshop.model.binding.FeedbackBindingModel;
import com.example.sunnysculinaryshop.model.entity.Feedback;
import com.example.sunnysculinaryshop.repository.FeedbackRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {
    
    private final FeedbackRepository feedbackRepository;
    private final ModelMapper modelMapper;

    public FeedbackService(FeedbackRepository feedbackRepository, ModelMapper modelMapper) {
        this.feedbackRepository = feedbackRepository;
        this.modelMapper = modelMapper;
    }

    public void saveFeedback(FeedbackBindingModel feedbackBindingModel) {
       feedbackRepository.save(modelMapper.map(feedbackBindingModel, Feedback.class));
    }
}
