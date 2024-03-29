package run.freshr.domain.auth.unit.redis;

import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import run.freshr.common.annotations.Unit;
import run.freshr.domain.auth.redis.RsaPair;
import run.freshr.domain.auth.repository.redis.RsaPairRepository;

@Slf4j
@Unit
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RsaPairUnitImpl implements RsaPairUnit {

  private final RsaPairRepository repository;

  @Override
  @Transactional
  public void save(RsaPair document) {
    repository.save(document);
  }

  @Override
  public Boolean exists(String id) {
    return repository.existsById(id);
  }

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
  @Override
  public Boolean checkRsa(String encodePublicKey, Long limit) {
    Optional<RsaPair> optional = repository.findById(encodePublicKey);

    if (optional.isEmpty()) {
      return false;
    }

    RsaPair redis = optional.get();

    if (redis.getCreateAt().plusSeconds(limit).isBefore(LocalDateTime.now())) {
      repository.deleteById(encodePublicKey);

      return false;
    }

    return true;
  }

  @Override
  public RsaPair get(String id) {
    return repository.findById(id).orElseThrow(EntityNotFoundException::new);
  }

  /**
   * 데이터 목록 조회
   *
   * @return list
   * @apiNote 데이터 목록 조회
   * @author FreshR
   * @since 2024. 3. 28. 오후 4:54:23
   */
  @Override
  public Iterable<RsaPair> getList() {
    return repository.findAll();
  }

  @Override
  @Transactional
  public void delete(String id) {
    repository.deleteById(id);
  }

  /**
   * 삭제
   *
   * @param list 데이터 목록
   * @apiNote 삭제
   * @author FreshR
   * @since 2024. 3. 28. 오후 4:54:23
   */
  @Override
  @Transactional
  public void delete(Iterable<RsaPair> list) {
    repository.deleteAll(list);
  }

}
