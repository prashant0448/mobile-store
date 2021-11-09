package com.prashant.mobilestore.Service;

import com.prashant.mobilestore.Model.Phone;
import com.prashant.mobilestore.Repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PhoneService {

    @Autowired
    PhoneRepository phoneRepository;

    public List<Phone> getAllPhones(){
        return phoneRepository.findAll();
    }

    public List<Phone> saveAllPhones(List<Phone> phones) {
        return phoneRepository.saveAll(phones);
    }

    public List<Phone> getSelectedPhones(@RequestParam MultiValueMap<String, String> params) {

        return phoneRepository.findAll(new Specification<Phone>() {
            @Override
            public Predicate toPredicate(Root<Phone> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(params!=null) {
                    for(Map.Entry<String, List<String>> m: params.entrySet())
                    {
                        for(String s: m.getValue()) {
                            predicates.add(criteriaBuilder.or(
                                    criteriaBuilder.like(root.get(m.getKey()), "%" + s + "%"))
                            );
                        }
                    }
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
    }


}
