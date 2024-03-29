package run.freshr.domain.auth.repository.redis;

import org.springframework.data.repository.CrudRepository;
import run.freshr.domain.auth.redis.AccessRedis;

/**
 * Access 토큰 관리 repository
 *
 * @author FreshR
 * @apiNote Access 토큰 관리 repository
 * @since 2024. 3. 28. 오후 4:54:23
 */
public interface AccessRedisRepository extends CrudRepository<AccessRedis, String> {

}
