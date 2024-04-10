package run.freshr.domain.auth.repository.redis;

import org.springframework.data.repository.CrudRepository;
import run.freshr.domain.auth.redis.RefreshRedis;

/**
 * Refresh 토큰 관리 repository
 *
 * @author FreshR
 * @apiNote Refresh 토큰 관리 repository
 * @since 2024. 3. 28. 오후 4:54:23
 */
public interface RefreshRedisRepository extends CrudRepository<RefreshRedis, String> {

}
