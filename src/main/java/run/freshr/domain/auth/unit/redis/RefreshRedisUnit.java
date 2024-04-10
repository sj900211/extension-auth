package run.freshr.domain.auth.unit.redis;

import run.freshr.common.extensions.unit.UnitDocumentDefaultExtension;
import run.freshr.domain.auth.redis.AccessRedis;
import run.freshr.domain.auth.redis.RefreshRedis;

/**
 * Refresh 토큰 관리 unit
 *
 * @author FreshR
 * @apiNote Refresh 토큰 관리 unit
 * @since 2024. 3. 28. 오후 4:54:23
 */
public interface RefreshRedisUnit extends UnitDocumentDefaultExtension<RefreshRedis, String> {

  /**
   * 삭제
   *
   * @param access Access 토큰 정보
   * @apiNote 삭제
   * @author FreshR
   * @since 2024. 3. 28. 오후 4:54:23
   */
  void delete(AccessRedis access);

}
