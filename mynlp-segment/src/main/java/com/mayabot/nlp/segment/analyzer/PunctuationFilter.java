/*
 * Copyright 2018 mayabot.com authors. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mayabot.nlp.segment.analyzer;

import com.mayabot.nlp.segment.WordTerm;
import com.mayabot.nlp.utils.Characters;

/**
 * 过滤标点符号
 *
 * @author jimichan
 */
public class PunctuationFilter extends FilterWordTermGenerator implements
        com.google.common.base.Predicate<WordTerm> {

    public PunctuationFilter(WordTermGenerator base) {
        super(base);
    }

    @Override
    public boolean test(WordTerm term) {
        if (term.word.length() == 1) {
            return !Characters.isPunctuation(term.word.charAt(0));
        } else if (term.word.length() == 2) {
            return !Characters.isPunctuation(term.word.charAt(0)) &&
                    !Characters.isPunctuation(term.word.charAt(1));
        } else {
            return !Characters.isPunctuation(term.word.charAt(0)) &&
                    !Characters.isPunctuation(term.word.charAt(1)) &&
                    !Characters.isPunctuation(term.word.charAt(2));
        }

    }

    @Override
    public boolean apply(WordTerm term) {
        return test(term);
    }
}
