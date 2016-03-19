package recept.domain.livsmedel;

import java.util.List;

/**
 * @Author: vda
 */
public interface LivsmedelRepository {

    List<Livsmedel> findByPartialName(String partialName);

    Livsmedel findByName(String name);


}
