package recept.dataaccess;

import recept.domain.livsmedel.Livsmedel;
import recept.domain.livsmedel.LivsmedelRepository;

import java.util.List;

/**
 * @Author: vda
 */
public class FileLivsmedelRepository implements LivsmedelRepository {
    @Override
    public List<Livsmedel> findByPartialName(String partialName) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Livsmedel findByName(String name) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
