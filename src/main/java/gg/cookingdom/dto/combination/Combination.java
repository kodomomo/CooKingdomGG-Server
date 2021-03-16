package gg.cookingdom.dto.combination;

import gg.cookingdom.enums.CombinationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Combination {
    private CombinationType type;
    private List<String> cookie;
    private List<String> treasure;
    private List<String> substitution;
}
