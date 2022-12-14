package com.tddtoday.tddtoday.controller;

import com.tddtoday.tddtoday.dto.CloseQuizDTO;
import com.tddtoday.tddtoday.entity.CloseQuizEntity;
import com.tddtoday.tddtoday.exception.CloseQuizNotFoundException;
import com.tddtoday.tddtoday.service.QuizQuestionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
public class CloseQuizController {

    private final QuizQuestionService quizQuestionService;


    private CloseQuizEntity applyPatchToCloseQuiz(
            JsonPatch patch, CloseQuizEntity targetCloseQuizEntity) throws JsonPatchException, JsonProcessingException {
        JsonNode patched = patch.apply(objectMapper.convertValue(targetCloseQuizEntity, JsonNode.class));
        return objectMapper.treeToValue(patched, CloseQuizEntity.class);
    }




    @PostMapping("/addCloseQuiz")
    public ResponseEntity<Void> addCloseQuiz(@RequestBody @Valid CloseQuizDTO closeQuizDTO) {
        log.info("Trying to add test abcd with question: {}", closeQuizDTO.getQuestion());
        quizQuestionService.addCloseQuiz(closeQuizDTO);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        log.info("Trying to delete test abcd with id: {}", id);
        quizQuestionService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    /// tutaj lece z domysłu 8.12


    @GetMapping("/{id}")
    public ResponseEntity<Void> readById(@PathVariable long id) {
        log.info("Trying to read test abcd with id: {}", id);

        quizQuestionService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
//

    }


    @PatchMapping(path = "/{id}", consumes = "application/json-patch+json")
    public ResponseEntity<CloseQuizEntity> updateQuiz(@PathVariable long id, @RequestBody JsonPatch patch) {
        try {
            CloseQuizEntity closeQuizEntity = quizQuestionService.getById(id).orElseThrow(CloseQuizNotFoundException::new);
            CloseQuizEntity closeQuizEntityPatched = applyPatchToCloseQuiz(patch, closeQuizEntity);
            quizQuestionService.updateQuiz(closeQuizEntityPatched);
            return ResponseEntity.ok(closeQuizEntityPatched);
        } catch (JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (CloseQuizNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }







//    @PatchMapping("/{id}/{answerA}")
//    public ResponseEntity<Void> patchAnswerAById( @PathVariable long id, @PathVariable String answerA){
//        log.info("Trying to replace Answer A with id: {}", id);
//
//
//            try {
//                CloseQuizEntity closeQuizEntity = abcdTestRepository.findById(id).get();
//                closeQuizEntity.setAnswerA(answerA);
//                return new ResponseEntity<CloseQuizEntity>(abcdTestRepository.save(closeQuizEntity), HttpStatus.OK);
//            } catch (Exception e) {
//                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }




}
