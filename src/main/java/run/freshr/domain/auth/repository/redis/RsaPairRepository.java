package run.freshr.domain.auth.repository.redis;

import org.springframework.data.repository.CrudRepository;
import run.freshr.domain.auth.redis.RsaPair;

/**
 * RSA 키 관리 repository
 *
 * @author FreshR
 * @apiNote RSA 키 관리 repository
 * @since 2024. 3. 28. 오후 4:54:23
 */
public interface RsaPairRepository extends CrudRepository<RsaPair, String> {

}
