package mighty.backend_springBoot.respository;

import mighty.backend_springBoot.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Users , UUID> {


}
