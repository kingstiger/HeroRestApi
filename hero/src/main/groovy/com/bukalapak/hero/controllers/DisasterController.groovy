package com.bukalapak.hero.controllers

import com.bukalapak.hero.models.Disaster
import com.bukalapak.hero.services.DisasterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

import javax.transaction.Transactional

@RestController
@RequestMapping('disaster')
@Transactional
class DisasterController {
  @Autowired
  DisasterService disasterService

  @GetMapping('')
  List findAll() {
    disasterService.findAll()
  }

  @GetMapping('/{id}')
  Disaster findById(@PathVariable('id') long id) {
    disasterService.findById(id)
  }
  
//posting with body - adding not-resolved disaster
  @PostMapping('')
  Disaster create(@RequestBody Disaster disaster) {
    disasterService.save(disaster)
  }

  @PutMapping('/{id}')
  Disaster update(@RequestBody Disaster disaster, @PathVariable('id') long id) {
    disasterService.update(disaster, id)
  }
  //post to disaster/id/heroID -> assigning hero
  @PostMapping('/{id}/{heroId}')
  Disaster assignHero(@PathVariable('id') long id, @PathVariable('heroId') long heroId) {
    disasterService.assignHero(id, heroId)
  }

  @DeleteMapping('/{id}/hero/{heroId}')
  Disaster removeHero(@PathVariable('id') long id, @PathVariable('heroId') long heroId) {
    disasterService.removeHero(id, heroId)
  }
//post without body - resolving disaster
  @PostMapping('/{id}')
  Disaster resolve(@PathVariable('id') long id) {
    disasterService.resolve(id)
  }

  @DeleteMapping('/{id}')
  Disaster deleteById(@PathVariable('id') long id) {
    disasterService.deleteById(id)
  }
}