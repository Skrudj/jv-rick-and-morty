package mate.academy.rickandmorty.repository.character;

import mate.academy.rickandmorty.model.CartoonCharacter;
import mate.academy.rickandmorty.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;

public class CharacterNameSpecificationProvider implements SpecificationProvider<CartoonCharacter> {
    @Override
    public Specification<CartoonCharacter> getSpecification(String name) {
        return (root, query, criteriaBuilder) -> root.get("name").in(name);
    }
}
