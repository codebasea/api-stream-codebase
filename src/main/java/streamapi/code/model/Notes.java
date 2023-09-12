package streamapi.code.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Notes {

    @JsonProperty("tagId")
    public Integer tagId;

    @JsonProperty("tagName")
    public String tagName;



    @JsonProperty("price")
    public Integer price;

    @JsonProperty("brand")
    public String brand;


}
