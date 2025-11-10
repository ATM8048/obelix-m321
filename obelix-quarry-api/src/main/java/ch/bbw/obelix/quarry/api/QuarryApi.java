package ch.bbw.obelix.quarry.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;
import java.util.UUID;

public interface QuarryApi {

    @GetExchange("/api/menhirs")
    List<MenhirDto> getAllMenhirs();

    @GetExchange("/api/menhirs/{menhirId}")
    MenhirDto getMenhirById(@PathVariable UUID menhirId);

    @DeleteExchange("/api/quarry/{menhirId}")
    void deleteById(@PathVariable UUID menhirId);
}
