/*
 * Copyright 2022-present Open Networking Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.opencord.olt;
/**
 * Enumerates the flow status.
 */
public enum OltFlowsStatus {
    /**
     * None status.
     */
    NONE,
    /**
     * Flow is pending add.
     */
    PENDING_ADD,
    /**
     * Flow is added.
     */
    ADDED,
    /**
     * Flow is pending remove.
     */
    PENDING_REMOVE,
    /**
     * Flow is removed.
     */
    REMOVED,
    /**
     * An error occurred.
     */
    ERROR;

    /**
     * Checks if this status means the flow is still available or in progress to be available.
     * @return true if the status represents an available flow.
     */
    public boolean hasFlow() {
        return !OltFlowsStatus.NONE.equals(this) && !OltFlowsStatus.REMOVED.equals(this);
    }
}