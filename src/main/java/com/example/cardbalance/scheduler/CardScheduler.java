package com.example.cardbalance.scheduler;

import com.example.cardbalance.services.abstraction.CardService;
import lombok.RequiredArgsConstructor;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CardScheduler {
    private final CardService service;

    @Scheduled(fixedDelayString = "PT1M")
    @SchedulerLock(name = "deleteAllInactiveCard",lockAtLeastFor = "PT1M",lockAtMostFor = "PT3M")
    public void deleteAllInactiveCard(){
        service.deleteAllInactiveCard();

    }

    @Scheduled(cron = "* * 3 * * *")
    @SchedulerLock(name = "updateBalance",lockAtLeastFor = "PT1M",lockAtMostFor = "PT3M")
    public void updateBalance(){
        service.updateBalance();

    }



}

