package calculator.core.mapper;

import java.util.ArrayList;
import java.util.List;

public interface Mapper {

    public String toOutput(ArrayList<Float> numbers);

    public ArrayList<Float> fromInput (List<String> numbers);
}
