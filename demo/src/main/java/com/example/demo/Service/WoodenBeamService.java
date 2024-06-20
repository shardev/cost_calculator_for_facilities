package com.example.demo.Service;

import com.example.demo.Model.Roof;
import org.springframework.stereotype.Service;

@Service
public interface WoodenBeamService {
    void proccesWoodenBeams(Roof roof, double upperLine);
}
