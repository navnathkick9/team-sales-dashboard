package com.company.teamsales.service;
import com.company.teamsales.entity.SalesRecord;
import com.company.teamsales.entity.User;
import com.company.teamsales.repository.SalesRepository;
import com.company.teamsales.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class SalesService {

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private UserRepository userRepository;
public List<SalesRecord> getMySales() {

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String username = auth.getName();

    User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("User not found"));

    return switch (user.getRole()) {
        case ADMIN -> salesRepository.findAll();

        case TL -> salesRepository.findByTlName(user.getEmployeeName());

        case AGENT -> salesRepository.findByEmployeeId(user.getEmployeeId());
    };
}
}