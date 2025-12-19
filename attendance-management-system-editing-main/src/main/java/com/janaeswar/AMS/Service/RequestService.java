package com.janaeswar.AMS.Service;

import com.janaeswar.AMS.Model.Request;
import com.janaeswar.AMS.Repository.RequestRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RequestService {
    private final RequestRepository repo;
    public RequestService(RequestRepository repo) { this.repo = repo; }
    public Request submit(Request r) { return repo.save(r); }
    public List<Request> byEmployee(Long employeeId) { return repo.findByEmployeeId(employeeId); }
    public Request updateStatus(Long id, String status) {
        Request r = repo.findById(id).orElseThrow(() -> new RuntimeException("Request not found"));
        r.setStatus(status);
        return repo.save(r);
    }
}
