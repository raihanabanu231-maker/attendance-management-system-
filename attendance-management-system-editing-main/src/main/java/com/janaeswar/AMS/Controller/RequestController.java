package com.janaeswar.AMS.Controller;

import com.janaeswar.AMS.Model.Request;
import com.janaeswar.AMS.Service.RequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/requests")
@CrossOrigin
public class RequestController {
    private final RequestService service;
    public RequestController(RequestService service) { this.service = service; }

    @PostMapping
    public Request submit(@RequestBody Request r) { return service.submit(r); }

    @GetMapping("/employee/{employeeId}")
    public List<Request> byEmployee(@PathVariable Long employeeId) { return service.byEmployee(employeeId); }

    @PostMapping("/{id}/status")
    public Map<String, Object> update(@PathVariable Long id, @RequestParam String status) {
        Request r = service.updateStatus(id, status);
        return Map.of("success", true, "id", r.getId(), "status", r.getStatus());
    }
}
