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
package com.mayabot.nlp.segment;

import java.io.Serializable;
import java.util.List;

/**
 * 一个词切分单元，用户可以直接访问此单词的全部属性
 * 改类类名以后不可以修改
 *
 * @author jimichan
 */
public final class WordTerm implements Serializable, WordAndNature {

    static final long serialVersionUID = 1L;

    /**
     * 词语
     */
    public final String word;

    /**
     * 词性
     */
    private Nature nature;

    /**
     * 在文本中的起始位置
     */
    public int offset;

    private int posInc = 1;

    /**
     * 索引分词，切分子词
     */
    private List<WordTerm> subword;

    private String customFlag;


    public WordTerm(String word) {
        this.word = word;
    }

    /**
     * 构造一个词
     *
     * @param word   词语
     * @param nature 词性
     */
    public WordTerm(String word, Nature nature) {
        this.word = word;
        this.nature = nature;
    }

    /**
     * 构造一个单词
     *
     * @param word   词语
     * @param nature 词性
     * @param offset 文本偏移位置
     */
    public WordTerm(String word, Nature nature, int offset) {
        this.word = word;
        this.nature = nature;
        this.offset = offset;
    }


    public Nature getNature() {
        return nature;
    }

    public String getNatureString() {
        if (nature == null) {
            return "";
        } else {
            return nature.name();
        }
    }

    public void setNature(Nature nature) {
        this.nature = nature;
    }

    public int getOffset() {
        return offset;
    }

    public List<WordTerm> getSubword() {
        return subword;
    }


    public boolean hasSubword() {
        return subword != null && !subword.isEmpty();
    }

    public String getWord() {
        return word;
    }

    @Override
    public String getNatureName() {
        return getNatureString();
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setSubword(List<WordTerm> subword) {
        this.subword = subword;
    }

    public String getCustomFlag() {
        return customFlag;
    }

    public void setCustomFlag(String customFlag) {
        this.customFlag = customFlag;
    }

    /**
     * 长度
     *
     * @return
     */
    public int length() {
        return word.length();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (nature == null) {
            sb.append(word);
        } else {
            sb.append(word).append("/").append(nature);
        }

        if (subword != null) {
            sb.append(subword);
        }

        return sb.toString();
    }

    public int getPosInc() {
        return posInc;
    }

    public WordTerm setPosInc(int posInc) {
        this.posInc = posInc;
        return this;
    }
}
