/*
 * Copyright 2015-2020 Jaemon(answer_ljm@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jaemon.dingtalk.dinger;


import com.jaemon.dingtalk.dinger.annatations.DingerTokenId;

/**
 * DingerResolver
 *
 * @author Jaemon#answer_ljm@163.com
 * @version 2.0
 */
public interface DingerResolver<T> {

    /**
     * resolveDingerDefinition
     *
     * @param keyName keyName
     * @param dinger dinger
     * @return dingerdefinition
     */
    DingerDefinition resolveDingerDefinition(String keyName, T dinger);

    /**
     * dingerConfig
     *
     * @param dingerTokenId dingerTokenId
     * @return dingerConfig
     */
    default DingerConfig dingerConfig(DingerTokenId dingerTokenId) {
        DingerConfig dingerConfig = new DingerConfig();
        dingerConfig.setTokenId(dingerTokenId.value());
        dingerConfig.setSecret(dingerTokenId.secret());
        dingerConfig.setDecryptKey(dingerTokenId.decryptKey());
        dingerConfig.check();
        return dingerConfig;
    }
}