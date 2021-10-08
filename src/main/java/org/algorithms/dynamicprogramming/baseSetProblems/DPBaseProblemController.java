package org.algorithms.dynamicprogramming.baseSetProblems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/dp")
public class DPBaseProblemController {

    private Logger log = LoggerFactory.getLogger(DPBaseProblemController.class);

    DPBaseProblemService dpBaseProblemService;

    public DPBaseProblemController(DPBaseProblemService dpBaseProblemService){
        this.dpBaseProblemService = dpBaseProblemService;
    }

    @GetMapping( path = "/maxProfitBA/{capacity}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> getMaxProfiBAt(@RequestBody  int[][] profitWeights, @PathVariable int capacity){
        try {
            int result = this.dpBaseProblemService.getMaxProfitBA(profitWeights[0], profitWeights[1], capacity);
            return ResponseEntity.ok(result);
        } catch(Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping( path = "/maxProfitTA/{capacity}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> getMaxProfitTA(@RequestBody  int[][] profitWeights, @PathVariable int capacity){
        try {
            int result = this.dpBaseProblemService.getMaxProfitTA(profitWeights[0], profitWeights[1], capacity);
            return ResponseEntity.ok(result);
        } catch(Exception e) {
            log.info(e.getLocalizedMessage());
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping(path = "/equalsSum", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> getEqualsSum(@RequestBody  int[] nums){
        try {
            Boolean result = this.dpBaseProblemService.canPartition(nums);
            return ResponseEntity.ok(result);
        } catch(Exception e) {
            log.info(e.getLocalizedMessage());
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping(path = "/CountOfSubsetSum/{sum}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> getCountSubsets(@RequestBody int[] nums, @PathVariable int sum){
        try {
            Integer result = this.dpBaseProblemService.countSubsets(nums, sum);
            return ResponseEntity.ok(result);
        } catch(Exception e) {
            log.info(e.getLocalizedMessage());
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(path = "/targetSum/{sum}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> getTargetSum(@RequestBody int[] nums, @PathVariable int sum){
        try{
          Integer result = this.dpBaseProblemService.findTargetSubsets(nums, sum);
          return ResponseEntity.ok(result);
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
