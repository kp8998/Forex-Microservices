package lk.ac.ucsc.forexservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

    //select * from exchangevalue where from = USA and to = LKR
    ExchangeValue findByFromAndTo(String from, String to);
}
