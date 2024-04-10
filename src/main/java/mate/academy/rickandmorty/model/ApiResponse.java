package mate.academy.rickandmorty.model;

import java.util.List;
import lombok.Data;

@Data
public class ApiResponse {
    private Info info;
    private List<CartoonCharacter> results;
}
