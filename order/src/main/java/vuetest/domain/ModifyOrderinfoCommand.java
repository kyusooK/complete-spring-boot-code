package vuetest.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ModifyOrderinfoCommand {

    private Long id;
    private Integer qty;
}
