/*-
 * Copyright 2018-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.ingogriebsch.sample.spring.data.jpa.repository;

import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
class PersonRepositoryTests {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    void findOneShouldReturnMatchingEntityIfAvailable() throws Exception {
        Person person = new Person(randomId(), "Ingo", 44);

        entityManager.persistAndFlush(person);
        Optional<Person> found = personRepository.findById(person.getId());

        Assertions.assertThat(found).isNotNull().get().isEqualTo(person);
    }

    @Test
    void findOneShouldReturnNullIfNotAvailable() throws Exception {
        Optional<Person> found = personRepository.findById(randomId());
        Assertions.assertThat(found).isNotNull().isEmpty();
    }

    @Test
    void insertShouldPersistEntity() throws Exception {
        Person person = new Person(randomId(), "Ingo", 44);

        Assertions.assertThat(personRepository.findById(person.getId())).isNotNull().isEmpty();

        personRepository.save(person);
        entityManager.flush();

        Optional<Person> found = personRepository.findById(person.getId());
        Assertions.assertThat(found).isNotNull().get().isEqualTo(person);
    }

    @Test
    // Start transaction
    void findByNameShouldReturnMatchingEntitiesIfAvailable() throws Exception {
        List<Person> persons = Lists.newArrayList(new Person(randomId(), "Ingo", 44), new Person(randomId(), "Jan", 32),
            new Person(randomId(), "Stephan", 34));
        persons.stream().forEach(p -> entityManager.persistAndFlush(p));
        Person person = persons.get(RandomUtils.nextInt(0, persons.size()));

        Iterable<Person> found = personRepository.findByName(person.getName());
        Assertions.assertThat(found).isNotNull().hasSize(1);
        Assertions.assertThat(found.iterator().next()).isEqualTo(person);
    }
    // Rollback transaction

    private static String randomId() {
        return RandomStringUtils.randomAlphanumeric(8);
    }

}
