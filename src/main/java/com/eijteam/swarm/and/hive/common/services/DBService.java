package com.eijteam.swarm.and.hive.common.services;

import com.eijteam.swarm.and.hive.modules.card.entities.Card;
import com.eijteam.swarm.and.hive.modules.card.enums.CardTypes;
import com.eijteam.swarm.and.hive.modules.card.repositories.CardRepository;
import com.eijteam.swarm.and.hive.modules.stage.entities.Difficulty;
import com.eijteam.swarm.and.hive.modules.stage.entities.Enemy;
import com.eijteam.swarm.and.hive.modules.stage.entities.Stage;
import com.eijteam.swarm.and.hive.modules.stage.entities.Wave;
import com.eijteam.swarm.and.hive.modules.stage.repositories.DifficultyRepository;
import com.eijteam.swarm.and.hive.modules.stage.repositories.EnemyRepository;
import com.eijteam.swarm.and.hive.modules.stage.repositories.StageRepository;
import com.eijteam.swarm.and.hive.modules.stage.repositories.WaveRepository;
import com.eijteam.swarm.and.hive.modules.user.entities.User;
import com.eijteam.swarm.and.hive.modules.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
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

    public void instantiateSeed() {
        User userSeed1 = new User(null, "DimiSilva", "jnn.sla@gmail.com", bCryptPasswordEncoder.encode("123456"));

        userRepository.saveAll(
                Arrays.asList(
                        userSeed1
                )
        );

        Difficulty difficultySeed1 = new Difficulty(null, "easy", 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F);
        Difficulty difficultySeed2 = new Difficulty(null, "medium", 1.2F, 1.2F, 1.1F, 0.8F, 0.8F, 1.2F);
        Difficulty difficultySeed3 = new Difficulty(null, "hard", 1.5F, 1.5F, 1.2F, 0.5F, 0.5F, 1.5F);

        difficultyRepository.saveAll(
                Arrays.asList(
                        difficultySeed1,
                        difficultySeed2,
                        difficultySeed3
                )
        );

        Enemy waxMothEnemy = new Enemy(null, "Traça de cera", 1.0F, 1.0F, 1.0F, 5.0F);
        Enemy fireAntEnemy = new Enemy(null, "Formiga de fogo", 3.0F, 1.0F, 1.3F, 10.0F);
        Enemy mantisEnemy = new Enemy(null, "Louva a deus", 4.0F, 4.0F, 0.8F, 10.0F);
        Enemy scarabBeetleEnemy = new Enemy(null, "Escaravelho", 0.8F, 8.0F, 0.5F, 12.0F);
        Enemy assassinBugEnemy = new Enemy(null, "Inseto assassino", 5F, 0.8F, 1.8F, 12.0F);

        enemyRepository.saveAll(
                Arrays.asList(
                        waxMothEnemy,
                        fireAntEnemy,
                        mantisEnemy,
                        scarabBeetleEnemy,
                        assassinBugEnemy
                )
        );

        Card workerCard = new Card(null, "Operária", "As abelhas operárias são estéreis e possuem diversas funções dentro da colméia, sendo uma delas a defesa", CardTypes.UNIT, 8.0F, 8.0F, 1.0F, null, null, null);
        Card lavenderFlowerCard = new Card(null, "Lavanda", "A lavanda é uma erva e terá como função o aumento da força e velocidade das abelhas próximas", CardTypes.BUFF_TOWER, null, null, null, 1.15F, 1.0F, 1.05F);
        Card mauveFlowerCard = new Card(null, "Malva", "A malva é uma planta perene e terá como função o aumento da defesa das abelhas próximas", CardTypes.BUFF_TOWER, null, null, null, 1.0F, 1.2F, 1.0F);
        Card sunflowerCard = new Card(null, "Girassol", "O girassol é uma Flor anul e terá como função o aumento da velocidade das abelhas próximas", CardTypes.BUFF_TOWER, null, null, null, 1.0F, 1.0F, 1.2F);

        cardRepository.saveAll(
                Arrays.asList(
                        workerCard,
                        lavenderFlowerCard,
                        mauveFlowerCard,
                        sunflowerCard
                )
        );

        Stage stageSeed1 = new Stage(null, 1, "Encontrando o lugar ideal parte 1", difficultySeed2, null);
        Stage stageSeed2 = new Stage(null, 2, "Encontrando o lugar ideal parte 2", difficultySeed2, null);
        Stage stageSeed3 = new Stage(null, 3, "Encontrando o lugar ideal parte 3", difficultySeed2, null);
        Stage stageSeed4 = new Stage(null, 4, "Construção dos favos parte 1", difficultySeed2, null);
        Stage stageSeed5 = new Stage(null, 5, "Construção dos favos parte 2", difficultySeed2, null);
        Stage stageSeed6 = new Stage(null, 6, "Expanção do enxame parte 1", difficultySeed2, null);
        Stage stageSeed7 = new Stage(null, 7, "Expanção do enxame parte 2", difficultySeed2, null);
        Stage stageSeed8 = new Stage(null, 8, "Encontrando um novo lugar ideal parte 1", difficultySeed2, null);
        Stage stageSeed9 = new Stage(null, 9, "Encontrando um novo lugar ideal parte 2", difficultySeed2, null);
        Stage stageSeed10 = new Stage(null, 10, "Encontrando um novo lugar ideal parte 3", difficultySeed2, null);

        stageRepository.saveAll(
                Arrays.asList(
                        stageSeed1,
                        stageSeed2,
                        stageSeed3,
                        stageSeed4,
                        stageSeed5,
                        stageSeed6,
                        stageSeed7,
                        stageSeed8,
                        stageSeed9,
                        stageSeed10
                )
        );

        Wave waveSeed1_1 = new Wave(null, 1, stageSeed1);
        Wave waveSeed1_2 = new Wave(null, 2, stageSeed1);
        Wave waveSeed1_3 = new Wave(null, 3, stageSeed1);

        Wave waveSeed2_1 = new Wave(null, 1, stageSeed2);
        Wave waveSeed2_2 = new Wave(null, 2, stageSeed2);
        Wave waveSeed2_3 = new Wave(null, 3, stageSeed2);

        Wave waveSeed3_1 = new Wave(null, 1, stageSeed3);
        Wave waveSeed3_2 = new Wave(null, 2, stageSeed3);
        Wave waveSeed3_3 = new Wave(null, 3, stageSeed3);

        Wave waveSeed4_1 = new Wave(null, 1, stageSeed4);
        Wave waveSeed4_2 = new Wave(null, 2, stageSeed4);
        Wave waveSeed4_3 = new Wave(null, 3, stageSeed4);

        Wave waveSeed5_1 = new Wave(null, 1, stageSeed5);
        Wave waveSeed5_2 = new Wave(null, 2, stageSeed5);
        Wave waveSeed5_3 = new Wave(null, 3, stageSeed5);

        Wave waveSeed6_1 = new Wave(null, 2, stageSeed6);
        Wave waveSeed6_2 = new Wave(null, 3, stageSeed6);
        Wave waveSeed6_3 = new Wave(null, 3, stageSeed6);

        Wave waveSeed7_1 = new Wave(null, 2, stageSeed7);
        Wave waveSeed7_2 = new Wave(null, 3, stageSeed7);
        Wave waveSeed7_3 = new Wave(null, 3, stageSeed7);
        Wave waveSeed7_4 = new Wave(null, 4, stageSeed7);

        Wave waveSeed8_1 = new Wave(null, 2, stageSeed8);
        Wave waveSeed8_2 = new Wave(null, 3, stageSeed8);
        Wave waveSeed8_3 = new Wave(null, 3, stageSeed8);
        Wave waveSeed8_4 = new Wave(null, 4, stageSeed8);

        Wave waveSeed9_1 = new Wave(null, 2, stageSeed9);
        Wave waveSeed9_2 = new Wave(null, 3, stageSeed9);
        Wave waveSeed9_3 = new Wave(null, 3, stageSeed9);
        Wave waveSeed9_4 = new Wave(null, 4, stageSeed9);

        Wave waveSeed10_1 = new Wave(null, 2, stageSeed10);
        Wave waveSeed10_2 = new Wave(null, 3, stageSeed10);
        Wave waveSeed10_3 = new Wave(null, 3, stageSeed10);
        Wave waveSeed10_4 = new Wave(null, 4, stageSeed10);

        waveRepository.saveAll(
                Arrays.asList(
                        waveSeed1_1,
                        waveSeed1_2,
                        waveSeed1_3,
                        waveSeed2_1,
                        waveSeed2_2,
                        waveSeed2_3,
                        waveSeed3_1,
                        waveSeed3_2,
                        waveSeed3_3,
                        waveSeed4_1,
                        waveSeed4_2,
                        waveSeed4_3,
                        waveSeed5_1,
                        waveSeed5_2,
                        waveSeed5_3,
                        waveSeed6_1,
                        waveSeed6_2,
                        waveSeed6_3,
                        waveSeed7_1,
                        waveSeed7_2,
                        waveSeed7_3,
                        waveSeed7_4,
                        waveSeed8_1,
                        waveSeed8_2,
                        waveSeed8_3,
                        waveSeed8_4,
                        waveSeed9_1,
                        waveSeed9_2,
                        waveSeed9_3,
                        waveSeed9_4,
                        waveSeed10_1,
                        waveSeed10_2,
                        waveSeed10_3,
                        waveSeed10_4
                )
        );

        userSeed1.getOpenCards().addAll(
                Arrays.asList(
                        lavenderFlowerCard,
                        mauveFlowerCard,
                        sunflowerCard,
                        workerCard
                )
        );

        userSeed1.getDeckCards().addAll(
                Arrays.asList(
                        lavenderFlowerCard,
                        mauveFlowerCard,
                        sunflowerCard,
                        workerCard
                )
        );


        userRepository.saveAll(
                Arrays.asList(
                        userSeed1
                )
        );

        waveSeed1_1.getEnemies().addAll(Arrays.asList(waxMothEnemy, waxMothEnemy, waxMothEnemy));
        waveSeed1_2.getEnemies().addAll(Arrays.asList(waxMothEnemy, waxMothEnemy, waxMothEnemy));
        waveSeed1_3.getEnemies().addAll(Arrays.asList(mantisEnemy));

        waveSeed2_1.getEnemies().addAll(Arrays.asList(waxMothEnemy, waxMothEnemy, waxMothEnemy));
        waveSeed2_2.getEnemies().addAll(Arrays.asList(fireAntEnemy, fireAntEnemy));
        waveSeed2_3.getEnemies().addAll(Arrays.asList(mantisEnemy, mantisEnemy));

        waveSeed3_1.getEnemies().addAll(Arrays.asList(waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy));
        waveSeed3_2.getEnemies().addAll(Arrays.asList(fireAntEnemy, fireAntEnemy, fireAntEnemy));
        waveSeed3_3.getEnemies().addAll(Arrays.asList(scarabBeetleEnemy, scarabBeetleEnemy));

        waveSeed4_1.getEnemies().addAll(Arrays.asList(waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy));
        waveSeed4_2.getEnemies().addAll(Arrays.asList(fireAntEnemy, fireAntEnemy, fireAntEnemy));
        waveSeed4_3.getEnemies().addAll(Arrays.asList(scarabBeetleEnemy, scarabBeetleEnemy, scarabBeetleEnemy));

        waveSeed5_1.getEnemies().addAll(Arrays.asList(waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy));
        waveSeed5_2.getEnemies().addAll(Arrays.asList(scarabBeetleEnemy, scarabBeetleEnemy, scarabBeetleEnemy, scarabBeetleEnemy));
        waveSeed5_3.getEnemies().addAll(Arrays.asList(assassinBugEnemy, assassinBugEnemy, assassinBugEnemy));

        waveSeed6_1.getEnemies().addAll(Arrays.asList(waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy));
        waveSeed6_2.getEnemies().addAll(Arrays.asList(scarabBeetleEnemy, scarabBeetleEnemy, scarabBeetleEnemy, scarabBeetleEnemy, scarabBeetleEnemy));
        waveSeed6_3.getEnemies().addAll(Arrays.asList(assassinBugEnemy, assassinBugEnemy, assassinBugEnemy, assassinBugEnemy));

        waveSeed7_1.getEnemies().addAll(Arrays.asList(waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy));
        waveSeed7_2.getEnemies().addAll(Arrays.asList(scarabBeetleEnemy, scarabBeetleEnemy, scarabBeetleEnemy, scarabBeetleEnemy, scarabBeetleEnemy));
        waveSeed7_3.getEnemies().addAll(Arrays.asList(mantisEnemy, mantisEnemy, mantisEnemy, mantisEnemy));
        waveSeed7_4.getEnemies().addAll(Arrays.asList(assassinBugEnemy, assassinBugEnemy, assassinBugEnemy, assassinBugEnemy));

        waveSeed8_1.getEnemies().addAll(Arrays.asList(waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy));
        waveSeed8_2.getEnemies().addAll(Arrays.asList(scarabBeetleEnemy, scarabBeetleEnemy, scarabBeetleEnemy, scarabBeetleEnemy, scarabBeetleEnemy));
        waveSeed8_3.getEnemies().addAll(Arrays.asList(fireAntEnemy, fireAntEnemy, fireAntEnemy, fireAntEnemy, fireAntEnemy));
        waveSeed8_4.getEnemies().addAll(Arrays.asList(assassinBugEnemy, assassinBugEnemy, assassinBugEnemy, assassinBugEnemy));

        waveSeed9_1.getEnemies().addAll(Arrays.asList(scarabBeetleEnemy, scarabBeetleEnemy, scarabBeetleEnemy, scarabBeetleEnemy, scarabBeetleEnemy, scarabBeetleEnemy));
        waveSeed9_2.getEnemies().addAll(Arrays.asList(waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy));
        waveSeed9_3.getEnemies().addAll(Arrays.asList(fireAntEnemy, fireAntEnemy, fireAntEnemy, fireAntEnemy, fireAntEnemy, fireAntEnemy));
        waveSeed9_4.getEnemies().addAll(Arrays.asList(assassinBugEnemy, assassinBugEnemy, assassinBugEnemy, assassinBugEnemy));

        waveSeed10_1.getEnemies().addAll(Arrays.asList(scarabBeetleEnemy, scarabBeetleEnemy, scarabBeetleEnemy, scarabBeetleEnemy, scarabBeetleEnemy, scarabBeetleEnemy));
        waveSeed10_2.getEnemies().addAll(Arrays.asList(waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy, waxMothEnemy));
        waveSeed10_3.getEnemies().addAll(Arrays.asList(fireAntEnemy, fireAntEnemy, fireAntEnemy, fireAntEnemy, fireAntEnemy, fireAntEnemy));
        waveSeed10_4.getEnemies().addAll(Arrays.asList(assassinBugEnemy, assassinBugEnemy, assassinBugEnemy, assassinBugEnemy, assassinBugEnemy));

        waveRepository.saveAll(
                Arrays.asList(
                        waveSeed1_1,
                        waveSeed1_2,
                        waveSeed1_3,
                        waveSeed2_1,
                        waveSeed2_2,
                        waveSeed2_3,
                        waveSeed3_1,
                        waveSeed3_2,
                        waveSeed3_3,
                        waveSeed4_1,
                        waveSeed4_2,
                        waveSeed4_3,
                        waveSeed5_1,
                        waveSeed5_2,
                        waveSeed5_3,
                        waveSeed6_1,
                        waveSeed6_2,
                        waveSeed6_3,
                        waveSeed7_1,
                        waveSeed7_2,
                        waveSeed7_3,
                        waveSeed7_4,
                        waveSeed8_1,
                        waveSeed8_2,
                        waveSeed8_3,
                        waveSeed8_4,
                        waveSeed9_1,
                        waveSeed9_2,
                        waveSeed9_3,
                        waveSeed9_4,
                        waveSeed10_1,
                        waveSeed10_2,
                        waveSeed10_3,
                        waveSeed10_4
                )
        );
    }
}
