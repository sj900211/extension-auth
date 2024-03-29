package run.freshr.domain.auth.unit.redis;

import static java.util.Objects.isNull;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import run.freshr.common.annotations.Unit;
import run.freshr.domain.auth.redis.AccessRedis;
import run.freshr.domain.auth.redis.RefreshRedis;
import run.freshr.domain.auth.repository.redis.RefreshRedisRepository;

@Slf4j
@Unit
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RefreshRedisUnitImpl implements RefreshRedisUnit {

  private final RefreshRedisRepository repository;

  @Override
  @Transactional
  public void save(RefreshRedis document) {
    repository.save(document);
  }

  @Override
  public Boolean exists(String id) {
    return repository.existsById(id);
  }

  @Override
  public RefreshRedis get(String id) {
    return repository.findById(id).orElseThrow(EntityNotFoundException::new);
  }

  @Override
  @Transactional
  public void delete(String id) {
    repository.deleteById(id);
  }

  /**
   * 삭제
   *
   * @param access Access 토큰 정보
   * @apiNote 삭제
   * @author FreshR
   * @since 2024. 3. 28. 오후 4:54:23
   */
  @Override
  @Transactional
  public void delete(AccessRedis access) {
    Iterable<RefreshRedis> refreshIterable = repository.findAll();

    refreshIterable.forEach(refresh -> {
      if (!isNull(refresh) && !isNull(refresh.getAccess())
          && refresh.getAccess().getId().equals(access.getId())) {
        repository.delete(refresh);
      }
    });
  }
  
}
