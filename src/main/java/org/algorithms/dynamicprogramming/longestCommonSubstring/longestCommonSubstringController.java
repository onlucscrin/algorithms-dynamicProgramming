package org.algorithms.dynamicprogramming.longestCommonSubstring;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tup/longestCommonSubstring")
public class longestCommonSubstringController {

    public longestCommonSubstringService lcsService;

    public longestCommonSubstringController(longestCommonSubstringService longestCommonSubstringService){
        this.lcsService = longestCommonSubstringService;
    }

    @GetMapping(path = "/longestCommonSubstring/{inputString}/{inputString2}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> minimumDeletionsStringPalindrome(@PathVariable String inputString, @PathVariable String inputString2){
        try{
            return ResponseEntity.ok(this.lcsService.findLongestCommonSubstring(inputString, inputString2));
        } catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping(path = "/longestCommonSubsequence/{inputString}/{inputString2}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> longestCommonSubsequence(@PathVariable String inputString, @PathVariable String inputString2){
        try{
            return ResponseEntity.ok(this.lcsService.findLongestCommonSubsequence(inputString, inputString2));
        } catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping(path = "/minimumDeleteionsInsertions/{inputString}/{inputString2}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> minimumDeletionsInsertions(@PathVariable String inputString, @PathVariable String inputString2){
        try{
            return ResponseEntity.ok(this.lcsService.minimumDeleteionsInsertions(inputString, inputString2));
        } catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping(path = "/longestIncreasingSubsequence", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> longestIncreasingSubsequence(@RequestBody int[] inputArray){
        try{
            return ResponseEntity.ok(this.lcsService.longestIncreasingSubsequence(inputArray));
        } catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping(path = "/LongestRepeatingSubsequence/{inputString}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> findLRSLength(@PathVariable String inputString){
        try{
            return ResponseEntity.ok(this.lcsService.findLRSLength(inputString));
        } catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping(path = "/SubsequencePatternMatching/{inputString}/{inputString2}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> findSPMCount(@PathVariable String inputString, @PathVariable String inputString2){
        try{
            return ResponseEntity.ok(this.lcsService.findSPMCount(inputString, inputString2));
        } catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
