package pl.uken.krakow.client_rabitmq.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Message {
    
    private String name;
    private String text;
    private LocalDateTime create_at;

}
