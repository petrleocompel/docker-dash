package cz.plc.prx.docker.dash.service;

import cz.plc.prx.docker.dash.model.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvironmentService {

    @Autowired
    DockerConnectionService dcService;

    public List<Environment> getAll() {
        return null;
    }
}
