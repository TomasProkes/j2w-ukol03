package cz.czechitas.java2webapps.ukol3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import cz.czechitas.java2webapps.ukol3.entity.Vizitka;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
public class VizitkaController {

  private List<Vizitka> seznamVizitek = List.of(
      new Vizitka("Gordon Sumner", "Sting s.r.o.", "Lake House, Wilford Cum Lake Amesbury", "Salisbury, Wiltshire UK", "sting@lakehouse.co.uk", null, null),
      new Vizitka("Björk Gudmundsdottir", "Björk a.s.", "Brautarholt", "105 Reykjavík, Höfuðborgarsvæðið, Island", null, "604 691 933", null),
      new Vizitka("Eric Clapton", "Slowhand Ltd.", "Hurtwood Edge", "Cranleigh, UK", null, null, "https://www.ericclapton.com/"),
      new Vizitka("Suzanne Vega", "Vega Inc.", "826 Broadway", "New York, USA", null, null, null)
  );

  @GetMapping("/")
  public ModelAndView seznam() {
    ModelAndView modelAndView = new ModelAndView("seznam");
    modelAndView.addObject("vizitky", seznamVizitek);
    return modelAndView;
  }

  @GetMapping("/detail/{id}")
  public ModelAndView detail(@PathVariable int id) {
    ModelAndView modelAndView = new ModelAndView("detail");
    modelAndView.addObject("vizitka", seznamVizitek.get(id));
    return modelAndView;
  }
}
