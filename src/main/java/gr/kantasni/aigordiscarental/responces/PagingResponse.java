package gr.kantasni.aigordiscarental.responces;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author DimitrisNikoltsanis
 */
@Data
public class PagingResponse {
    private List<Object> resultList;
    private int totalPages;

    public PagingResponse(List<Object> resultList, int totalPages) {
        this.resultList = resultList;
        this.totalPages = totalPages;
    }
}