package com.bukalapak.hero.repositories

import com.bukalapak.hero.models.Ability
import org.springframework.data.repository.PagingAndSortingRepository

// we only need CRUD for Ability because it won't have its own endpoints
interface AbilityRepository extends PagingAndSortingRepository<Ability, Long> {}