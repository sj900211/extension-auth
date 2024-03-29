package run.freshr.domain.auth.unit.redis;

import run.freshr.common.extensions.unit.UnitDocumentDefaultExtension;
import run.freshr.domain.auth.redis.AccessRedis;

/**
 * Access 토큰 관리 unit
 *
 * @author FreshR
 * @apiNote Access 토큰 관리 unit
 * @since 2024. 3. 28. 오후 4:54:23
 */
public interface AccessRedisUnit extends UnitDocumentDefaultExtension<AccessRedis, String> {

  /**
   * 데이터 존재 여부
   *
   * @param signId 계정 일련 번호
   * @return boolean
   * @apiNote 데이터 존재 여부
   * @author FreshR
   * @since 2024. 3. 28. 오후 4:54:23
   */
  Boolean existsBySignId(String signId);

  /**
   * 데이터 조회
   *
   * @param signId 계정 일련 번호
   * @return access redis
   * @apiNote 데이터 조회
   * @author FreshR
   * @since 2024. 3. 28. 오후 4:54:23
   */
  AccessRedis getBySignId(String signId);

  /**
   * 데이터 목록 조회
   *
   * @return list
   * @apiNote 데이터 목록 조회
   * @author FreshR
   * @since 2024. 3. 28. 오후 4:54:23
   */
  Iterable<AccessRedis> getList();

  /**
   * 삭제
   *
   * @param signId 계정 일련 번호
   * @apiNote 삭제
   * @author FreshR
   * @since 2024. 3. 28. 오후 4:54:23
   */
  void deleteBySignId(String signId);

}
