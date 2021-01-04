package com.eijteam.swarm.and.hive.configs;

import com.eijteam.swarm.and.hive.modules.card.entities.Card;
import com.eijteam.swarm.and.hive.modules.card.enums.CardTypes;
import com.eijteam.swarm.and.hive.modules.card.repositories.CardRepository;
import com.eijteam.swarm.and.hive.modules.stage.entities.Difficulty;
import com.eijteam.swarm.and.hive.modules.stage.entities.Enemy;
import com.eijteam.swarm.and.hive.modules.stage.repositories.DifficultyRepository;
import com.eijteam.swarm.and.hive.modules.stage.repositories.EnemyRepository;
import com.eijteam.swarm.and.hive.modules.stage.entities.Stage;
import com.eijteam.swarm.and.hive.modules.stage.repositories.StageRepository;
import com.eijteam.swarm.and.hive.modules.user.entities.User;
import com.eijteam.swarm.and.hive.modules.user.repositories.UserRepository;
import com.eijteam.swarm.and.hive.modules.stage.entities.Wave;
import com.eijteam.swarm.and.hive.modules.stage.repositories.WaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private StageRepository stageRepository;
    @Autowired
    private DifficultyRepository difficultyRepository;
    @Autowired
    private EnemyRepository enemyRepository;
    @Autowired
    private WaveRepository waveRepository;

    @Override
    public void run(String... args) throws Exception {
        User userSeed1 = new User(null, "user1", "user1@email.com", bCryptPasswordEncoder.encode("123"));
        User userSeed2 = new User(null, "user2", "user2@email.com", bCryptPasswordEncoder.encode("123"));

        userRepository.saveAll(Arrays.asList(userSeed1, userSeed2));

        Difficulty difficultySeed1 = new Difficulty(null, "difficulty1", 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F);
        Difficulty difficultySeed2 = new Difficulty(null, "difficulty2", 2.0F, 2.0F, 2.0F, 0.5F, 0.5F, 2.0F);
        Difficulty difficultySeed3 = new Difficulty(null, "difficulty3", 3.0F, 3.0F, 3.0F, 0.25F, 0.25F, 3.0F);

        difficultyRepository.saveAll(Arrays.asList(difficultySeed1, difficultySeed2, difficultySeed3));

        Enemy enemySeed1 = new Enemy(null, "enemy1", 10.0F, 10.0F, 10.0F, 5.0F);
        Enemy enemySeed2 = new Enemy(null, "enemy2", 12.0F, 12.0F, 12.0F, 10.0F);
        Enemy enemySeed3 = new Enemy(null, "enemy3", 14.0F, 14.0F, 14.0F, 15.0F);

        enemyRepository.saveAll(Arrays.asList(enemySeed1, enemySeed2, enemySeed3));

        Card cardSeed1 = new Card(null, "card1", "Carta de seed 1", CardTypes.ATTACK_TOWER);
        Card cardSeed2 = new Card(null, "card2", "Carta de seed 2", CardTypes.BUFF_TOWER);
        Card cardSeed3 = new Card(null, "card3", "Carta de seed 3", CardTypes.UNIT);
        Card cardSeed4 = new Card(null, "card4", "Carta de seed 4", CardTypes.ATTACK_TOWER);
        Card cardSeed5 = new Card(null, "card5", "Carta de seed 5", CardTypes.MAGIC);
        Card cardSeed6 = new Card(null, "card6", "Carta de seed 6", CardTypes.ATTACK_TOWER);

        cardRepository.saveAll(Arrays.asList(cardSeed1, cardSeed2, cardSeed3, cardSeed4, cardSeed5, cardSeed6));

        Stage stageSeed1 = new Stage(null, 1, "stage1", difficultySeed1, cardSeed2);
        Stage stageSeed2 = new Stage(null, 2, "stage2", difficultySeed2, cardSeed4);
        Stage stageSeed3 = new Stage(null, 3, "stage3", difficultySeed3, cardSeed6);

        stageRepository.saveAll(Arrays.asList(stageSeed1, stageSeed2, stageSeed3));

        Wave waveSeed1 = new Wave(null, 1, stageSeed1);
        Wave waveSeed2 = new Wave(null, 2, stageSeed2);
        Wave waveSeed3 = new Wave(null, 3, stageSeed3);

        waveRepository.saveAll(Arrays.asList(waveSeed1, waveSeed2, waveSeed3));

        userSeed1.getOpenCards().addAll(Arrays.asList(cardSeed1, cardSeed3, cardSeed5));
        userSeed2.getOpenCards().addAll(Arrays.asList(cardSeed1, cardSeed3, cardSeed5));

        userRepository.saveAll(Arrays.asList(userSeed1, userSeed2));

        waveSeed1.getEnemies().addAll(Arrays.asList(enemySeed1, enemySeed2, enemySeed3));
        waveSeed2.getEnemies().addAll(Arrays.asList(enemySeed1, enemySeed2));
        waveSeed3.getEnemies().addAll(Arrays.asList(enemySeed2, enemySeed3));

        waveRepository.saveAll(Arrays.asList(waveSeed1, waveSeed2, waveSeed3));
    }
}
