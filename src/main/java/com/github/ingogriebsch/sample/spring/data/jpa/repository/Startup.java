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

import static com.google.common.collect.Sets.newHashSet;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class Startup implements CommandLineRunner {

    @NonNull
    private final PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
        newHashSet(person("Ingo", 44), person("Marcel", 33), person("Sophia", 21)).stream().forEach(p -> insert(p));
    }

    private void insert(Person person) {
        personRepository.save(person);
        log.info("Inserting person '{}'...", person);
    }

    private static Person person(String name, Integer age) {
        return new Person(randomAlphanumeric(8), name, age);
    }
}
