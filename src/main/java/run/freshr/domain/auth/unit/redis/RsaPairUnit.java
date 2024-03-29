package run.freshr.domain.auth.unit.redis;

import run.freshr.common.extensions.unit.UnitDocumentDefaultExtension;
import run.freshr.domain.auth.redis.RsaPair;

/**
 * RSA 키 관리 unit
 *
 * @author FreshR
 * @apiNote RSA 키 관리 unit
 * @since 2024. 3. 28. 오후 4:54:23
 */
public interface RsaPairUnit extends UnitDocumentDefaultExtension<RsaPair, String> {

  /**
   * 데이터 목록 조회
   *
   * @return list
   * @apiNote 데이터 목록 조회
   * @author FreshR
   * @since 2024. 3. 28. 오후 4:54:23
   */
  Iterable<RsaPair> getList();

  /**
   * 삭제
   *
   * @param list 데이터 목록
   * @apiNote 삭제
   * @author FreshR
   * @since 2024. 3. 28. 오후 4:54:23
   */
  void delete(Iterable<RsaPair> list);

  /**
   * 유효 기간 검증
   *
   * @param encodePublicKey BASE64 로 인코딩된 RSA 공개 키
   * @param limit           유효 기간
   * @return boolean
   * @apiNote 유효 기간 검증
   * @author FreshR
   * @since 2024. 3. 28. 오후 4:54:23
   */
  Boolean checkRsa(String encodePublicKey, Long limit);

}
