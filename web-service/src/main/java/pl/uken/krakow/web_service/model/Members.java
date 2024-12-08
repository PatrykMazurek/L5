package pl.uken.krakow.web_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Members {
    int id;
    String lastFirstName;
    String function;
    String mandateExpired;
    String club;
}
