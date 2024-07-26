package Common;

import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class YamlReader {

    public static List<Map<String, Object>> readYaml(String filePath) {
        Yaml yaml = new Yaml();
        InputStream inputStream = YamlReader.class
            .getClassLoader()
            .getResourceAsStream(filePath);
        return yaml.load(inputStream);
    }
}
