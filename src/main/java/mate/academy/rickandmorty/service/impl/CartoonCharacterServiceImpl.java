package mate.academy.rickandmorty.service.impl;

import java.security.SecureRandom;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.model.CartoonCharacter;
import mate.academy.rickandmorty.repository.CartoonCharacterRepository;
import mate.academy.rickandmorty.repository.character.CharacterNameSpecificationProvider;
import mate.academy.rickandmorty.service.CartoonCharacterService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartoonCharacterServiceImpl implements CartoonCharacterService {
    private final CartoonCharacterRepository characterRepository;
    private final CharacterNameSpecificationProvider nameSpecificationProvider;

    @Override
    public CartoonCharacter getRandomCharacter() {
        List<CartoonCharacter> characters = characterRepository.findAll();
        Random random = new SecureRandom();
        int randomIndex = random.nextInt(characters.size());

        return characters.get(randomIndex);
    }

    @Override
    public List<CartoonCharacter> getByName(String name) {
        Specification<CartoonCharacter> specification = nameSpecificationProvider.getSpecification(name);

        return characterRepository.findAll(specification);
    }

    @Override
    public CartoonCharacter save(CartoonCharacter entity) {
        return characterRepository.save(entity);
    }

    @Override
    public List<CartoonCharacter> getAll() {
        return characterRepository.findAll();
    }

    @Override
    public CartoonCharacter getById(Long id) {
        return characterRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Character by id: " + id + " does not exists"));
    }

    @Override
    public void update(CartoonCharacter entity) {
        characterRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        characterRepository.deleteById(id);
    }
}
